package io.fourfinanceit.homework.dao;

import io.fourfinanceit.homework.entity.Loan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoanDao {
	@Autowired
	SessionFactory sessionFactory;

	public void addLoan(Loan loan) {
		sessionFactory.getCurrentSession().save(loan);
	}

	public int getUserLoanAttempts(Loan loan) {
		List loans = sessionFactory.getCurrentSession()
				.createCriteria(Loan.class)
				.add(Restrictions.eq("date", loan.getDate()))
				.add(Restrictions.eq("requesterAddr", loan.getRequesterAddr()))
				.list();

		return loans.size();
	}
}
