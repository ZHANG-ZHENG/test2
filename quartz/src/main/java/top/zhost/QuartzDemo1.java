package top.zhost;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
/**
 * 任务类
 */
public class QuartzDemo1 implements Job{
	
	public static Integer count = 0;
	
    /**
     * 任务被触发时执行的方法
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getTrigger().getJobDataMap();// 任务所配置的数据映射表
        Long taskId = null;
        if (dataMap != null && dataMap.size() > 0) {
            taskId = dataMap.getLong("TASK_ID");
          
        }

        count++;
        
        Scheduler scheduler = context.getScheduler();
        if(count == 3){
        	try {
				scheduler.unscheduleJob("triggerName", "triggerGroup");
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
        }
        
        System.out.println(taskId+ "你收到消息了。。。 "+count +" "+context.getTrigger().getNextFireTime());
    }
}
