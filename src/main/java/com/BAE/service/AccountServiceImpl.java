package com.BAE.service;

import java.util.List;

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
