package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.entity.Userdata;
import com.example.entity.Walletaccount;
import com.example.entity.Wallettransaction;


@Repository
public class WallettransactiondaoImpl implements Wallettransactiondao{
	
	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public List<Wallettransaction> getAllTransaction() {
		Query q=em.createQuery("select m from Wallettransaction m");
		List<Wallettransaction> translist=q.getResultList();
		return translist;
		
	}

	@Override
	public List<Wallettransaction> getAllTransactionById(Walletaccount wa) {
	    
		Walletaccount wal_account=em.find(Walletaccount.class, wa.getAccountid());
		if(wal_account!=null){
		Query q=em.createQuery("select m from Wallettransaction m where m.accountid=?1");
		q.setParameter(1, wa.getAccountid());
		List<Wallettransaction> translist=q.getResultList();
		return translist;
		}
		else
		{
			return null;
		}
	}

}