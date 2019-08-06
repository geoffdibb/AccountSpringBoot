package com.BAE.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.BAE.domain.Account;
import com.BAE.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	private RestTemplate restTemplate;

	public AccountServiceImpl() {

	}

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository, RestTemplate restTemplate ) {
		this.accountRepository = accountRepository;
		this.restTemplate = restTemplate;
		
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account createAccount(Account account) {

		
			ResponseEntity<String> exchangeAccount = restTemplate.exchange("http://localhost:8081/NumberG/getNumber",
					HttpMethod.GET, null, String.class);
			
			account.setaccountNumber(exchangeAccount.getBody());
			
			
			ResponseEntity<String> exchangeAccount2 = restTemplate.exchange("http://localhost:8082/PrizeG/getPrize",
					HttpMethod.GET, null, String.class);
			
			account.setprizewinner(exchangeAccount2.getBody());
			
			
				return accountRepository.save(account);

	}

	@Override
	public String updateAccount(Account account) {

		accountRepository.deleteById(account.getId());

		accountRepository.save(account);

		return account.toString();
	}

	public String deleteAccount(Account account) {
		accountRepository.delete(account);
		return "Account Successfully deleted";
	}

}
