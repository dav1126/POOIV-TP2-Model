import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.sun.javafx.print.Units;



/**
 * Class used to create and manage a pool of ThrProd thread
 */
public class ProdThreadPool
{
	/**
	 * Max thread number in the thread pool
	 */
	private static final int MAX_THREAD_NUMBER = 6;

	/**
	 * Executor made to manage a pool of thread and start them periodically
	 */
	private ScheduledExecutorService scheduledThreadPool;

	/**
	 * ProdThreadPool constructor that sets the maximum number of thread to
	 * MAX_THREAD_NUMBER and executes a threadProd with a fixed delay
	 * @param qty
	 * @param reserve
	 * @param delay
	 */
	public ProdThreadPool(int qty, Reserve reserve, int delay)
	{
		ThrProd threadProd = new ThrProd(qty, reserve, delay);
		scheduledThreadPool = new ScheduledThreadPoolExecutor(MAX_THREAD_NUMBER);
		scheduledThreadPool.scheduleAtFixedRate(threadProd, 0, threadProd.getDelay(), TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Return the scheduledExecutorService
	 * @return 
	 */
	public ScheduledExecutorService getScheduledThreadPool()
	{
		return scheduledThreadPool;
	}
}
