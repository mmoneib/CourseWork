package io.fourfinanceit.homework.controller;

import io.fourfinanceit.homework.dao.LoanDao;
import io.fourfinanceit.homework.entity.Loan;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
	@Autowired
	private LoanDao loanDao;

	private static final String REJECTION_MESSAGE = "Sorry, your request for loan was rejected.";
	private static final int MAX_POSSIBLE_AMOUNT = 99999;
	private static final int USER_MAX_APPLICATION_NUM_PER_DAY = 3;

	@RequestMapping("/loan")
	public String loan(
			@RequestParam(value = "firstName") final String firstName,
			@RequestParam(value = "lastName") final String lastName,
			@RequestParam(value = "amount") final String amount,
			@RequestParam(value = "term") final String term,
			HttpServletRequest request, Model model) {
		Loan loan = new Loan(firstName, lastName, amount, term,
				request.getRemoteAddr());
		model.addAttribute("loan", loan);
		loanDao.addLoan(loan);

		return calculateRisk(loan, loanDao.getUserLoanAttempts(loan));
	}

	protected boolean checkMaximumNumberOfApplications(
			int userNumberofApplicationsPerDay) {
		if (USER_MAX_APPLICATION_NUM_PER_DAY < userNumberofApplicationsPerDay) {
			return false;
		} else {
			return true;
		}
	}

	protected boolean checkDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		if (hours >= 0 && hours <= 6) {
			return true;
		} else {
			return false;
		}
	}

	protected String calculateRisk(Loan loan, int userNumberofApplicationsPerDay) {
		if (checkDate(loan.getDate())
				&& checkMaximumPossibleAmount(loan.getAmount())) {
			return REJECTION_MESSAGE;
		} else if (checkMaximumNumberOfApplications(userNumberofApplicationsPerDay)) {
			return REJECTION_MESSAGE;
		} else {
			return loan.getId() + "";
		}
	}

	protected boolean checkMaximumPossibleAmount(int amount) {
		if (amount == MAX_POSSIBLE_AMOUNT) {
			return true;
		} else {
			return false;
		}
	}

}
