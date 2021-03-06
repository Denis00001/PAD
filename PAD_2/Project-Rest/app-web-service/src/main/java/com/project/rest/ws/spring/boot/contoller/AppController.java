
package com.project.rest.ws.spring.boot.contoller;

import com.project.entity.Transaction;
import com.project.repository.TransactionRepositoryIntf;
import com.project.utils.Serializer;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AppController {

    private static final Logger LOG = Logger.getLogger(AppController.class.getName());

    
    @Autowired
    TransactionRepositoryIntf transactionRepository;

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public @ResponseBody
    String showLoginPage(ModelMap model) {
        return "Processing aap1";
    }
    
    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public @ResponseBody
    String getTransactions(ModelMap model) {
        List<Transaction> transactionList = transactionRepository.findAll();
        return transactionList.toString();
    }
    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)
    public @ResponseBody
    String findTransactionById(@PathVariable Integer id) {
        LOG.info("### Web Service Method - findTransactionById called for user id = "+id);
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        //Transaction transaction = transactionOptional.get();
        //return transaction.toString();
        return "from transaction 1";
    }
    
    @RequestMapping(value = "/formatTransactions/{transaction_format}", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody
    String formatTransactions(@PathVariable String transaction_format) {
        LOG.info("### Web Service Method - formatTransaction to = "+transaction_format);
        List<Transaction> transactionList = transactionRepository.findAll();
        String response=" ";
        if(transaction_format.equals("json")){
            for(Transaction transaction: transactionList){
                response+=Serializer.serializeToJson(transaction);
            }
        } else if(transaction_format.equals("xml")){
            for(Transaction transaction: transactionList){
                response+=Serializer.serializeToXML(transaction);
                LOG.info("**********"+response);
            }
        }
        
        return response+" ";
    }
    
    
}
