package com.BAE.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.BAE.domain.Account;
import com.BAE.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	public AccountServiceImpl() {

	}

	@Autowired
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account createAccount(Account account) {
		Random rand = new Random(); 
		int numgen = rand.nextInt(3);

		if(numgen== 1) {
			int accountnumber1 = rand.nextInt(899999) + 100000;

			account.setaccountNumber(accountnumber1);
			
			account.setprize("Little winner £50");

	}
		else if(numgen== 2){
			int accountnumber2 = rand.nextInt(89999999) + 10000000;

		account.setaccountNumber(accountnumber2);
		account.setprize("Medium winner £100");

	}
		else {
			int accountnumber3 = rand.nextInt(899999999) + 1000000000;

		account.setaccountNumber(accountnumber3);
		account.setprize("Big winner £500");

		}
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
