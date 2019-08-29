package top.zhost;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartz1 {
    public static void main(String[] args) {

        //3创建Scheduler(任务调度)对象
        try {
            Scheduler scheduler=StdSchedulerFactory.getDefaultScheduler();  
            System.out.println(scheduler.isStarted());
            scheduler.start();
            System.out.println(scheduler.isStarted());

            
            Trigger trigger = new CronTrigger("triggerName", "triggerGroup", "jobName", "jobGroup", "0/4 * * * * ?");
            trigger.getJobDataMap().put("TASK_ID", 1000L);
            trigger.getJobDataMap().put("count", 0);
            JobDetail jobDetail = new JobDetail("jobName", "jobGroup",QuartzDemo1.class);    
            scheduler.scheduleJob(jobDetail,trigger);
            
            Trigger trigger2 = new CronTrigger("triggerName2", "triggerGroup", "jobName2", "jobGroup", "0/2 * * * * ?");
            JobDetail jobDetail2 = new JobDetail("jobName2", "jobGroup",QuartzDemo2.class);    
            Date nextExecutionTime = scheduler.scheduleJob(jobDetail2,trigger2);
            System.out.println(nextExecutionTime);

            
            //停止
            Trigger triggerz = scheduler.getTrigger("triggerName", "triggerGroup");
            if (triggerz != null) {
            	scheduler.unscheduleJob("triggerName", "triggerGroup");
            }
            //修改

            
            scheduler.shutdown();
            
//            // Trigger已存在，那么更新相应的定时设置
//            ((CronTrigger) trigger).setCronExpression(task.getOptCron());
//            nextExecutionTime = operatorScheduler.rescheduleJob(trigger.getName(), trigger.getGroup(), trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       
    }
}