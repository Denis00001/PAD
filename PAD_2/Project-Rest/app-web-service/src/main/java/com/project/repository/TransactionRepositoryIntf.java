
package com.project.repository;

import com.project.entity.Transaction;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepositoryIntf extends CassandraRepository<Transaction, Integer> {
    
}
