package br.com.designpattern.observer.job;

import br.com.designpattern.observer.notifier.Notifier;
import br.com.designpattern.observer.repository.OrderRepository;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ProcessOrderJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getMergedJobDataMap();

        OrderRepository orderRepository = (OrderRepository) jobDataMap.get("orderRepository");
        Notifier notifier = (Notifier) jobDataMap.get("notifier");

        notifier.newOrders(orderRepository.getAll());
    }

}
