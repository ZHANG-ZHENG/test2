package top.zhost;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * 任务类
 */
public class QuartzDemo2 implements Job{
    /**
     * 任务被触发时执行的方法
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("你收到消息了。。。22");
    }
}
