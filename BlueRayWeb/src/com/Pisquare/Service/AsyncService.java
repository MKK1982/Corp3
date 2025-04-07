package com.Pisquare.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.Pisquare.Beans.SimpleBranch;
import com.Pisquare.Dao.UserDetailsDao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Autowired
    private UserDetailsDao dao10;

    @Async
    public CompletableFuture<List<SimpleBranch>> getFD_MasterList(String From_Date,String To_Date,int dbCode) {
        // Simulate a delay to represent a long-running task, e.g., DB query
    	System.out.println("Inside Asyc getFD_MasterList");
        List<SimpleBranch> list=dao10.getFD_MasterList(From_Date,To_Date,dbCode);
        return CompletableFuture.completedFuture(list);
    }
    
    
    
}
