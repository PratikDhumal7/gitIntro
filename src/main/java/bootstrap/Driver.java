package bootstrap;


import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {

    /**
     Implementation starting here
     */
    static Logger logger = LoggerFactory.getLogger(Driver.class);
    public static void main(String[] args) throws Exception {
        configureLogging("var/log/gitIntro/",false);
        logger.info("Hello World!!");

    }

    public static String configureLogging(String logDirectory, boolean debug) {
        DailyRollingFileAppender dailyRollingFileAppender = new DailyRollingFileAppender();

        String logFileName = "";
        if (!debug) {
            dailyRollingFileAppender.setThreshold(Level.toLevel(Priority.INFO_INT));
            logFileName = logDirectory + "introToGit.log";

        } else {
            dailyRollingFileAppender.setThreshold(Level.toLevel(Priority.DEBUG_INT));
            logFileName = logDirectory + "introToGitDebug.log";
        }

        System.out.println("Log files written out at " + logFileName);
        dailyRollingFileAppender.setFile(logFileName);
        dailyRollingFileAppender.setLayout(new EnhancedPatternLayout("%-6d [%t] %-5p %c - %m%n"));

        dailyRollingFileAppender.activateOptions();
        org.apache.log4j.Logger.getRootLogger().addAppender(dailyRollingFileAppender);
        return dailyRollingFileAppender.getFile();
    }

}
