package br.com.designpattern.observer;

import br.com.designpattern.observer.job.ProcessOrderJob;
import br.com.designpattern.observer.listener.Listener;
import br.com.designpattern.observer.listener.impl.BillingOrder;
import br.com.designpattern.observer.listener.impl.ReserveTruck;
import br.com.designpattern.observer.notifier.Notifier;
import br.com.designpattern.observer.notifier.impl.OrderNotifier;
import br.com.designpattern.observer.repository.OrderRepository;
import br.com.designpattern.observer.repository.impl.OrderXmlRepository;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws SchedulerException, ParseException {
        Notifier notifier = new OrderNotifier();

        Listener reserveTruckListener = new ReserveTruck(notifier);
        Listener billingOrderListener = new BillingOrder(notifier);

        JobDataMap jobDataMap = new JobDataMap();
        OrderRepository orderRepository = new OrderXmlRepository("pedidos.xml");

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        jobDataMap.put("orderRepository", orderRepository);
        jobDataMap.put("notifier", notifier);

        JobDetail jobDetail = JobBuilder.newJob(ProcessOrderJob.class)
                .setJobData(jobDataMap)
                .withIdentity(UUID.randomUUID().toString(), "orderGroup")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().toString())
                .startAt(Date.from(Instant.now()))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
    }

}
