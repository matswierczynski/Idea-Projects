package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Queue queue=new Queue();
        ArrayList<Request> request=new ArrayList<Request>(queue.returnQueue());
        FCFS fcfs=new FCFS(request);
        SSTF sstf=new SSTF(request);
        SCAN scan=new SCAN(request);
        CSCAN cscan=new CSCAN(request);
        EDF edf=new EDF(request);
        System.out.println("FCFS: "+fcfs.handle());
        System.out.println("SSTF: "+sstf.handle());
        System.out.println("SCAN: "+scan.handle());
        System.out.println("CSCAN: "+cscan.handle());
        System.out.println("EDF: "+edf.handle());

    }
}
