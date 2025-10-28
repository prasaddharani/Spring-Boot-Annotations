package com.example.annotations.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class StudentSchedulingService {

    //@Scheduled(cron = "*/10 * * * * *")
    public void cronExpression() {
        System.out.println("Running with cron expression : "+ LocalDateTime.now());
    }

//    @Scheduled(fixedDelay = 1000)
//    public void fixedDelay() {
//        System.out.println("Running with fixed delay: " + LocalDateTime.now());
//    }

    @Scheduled(initialDelay = 1000, fixedRate = 3000)
    public void fixedRateWithInitialDelay() {
        System.out.println("Running with fixed rate and initial delay: " + LocalDateTime.now());
    }

        /*

    | Field         | Allowed Values        | Description                                       | Example Value |
    |---------------|-----------------------|---------------------------------------------------|---------------|
    | Second        | 0-59                  | Seconds of the minute                             | \*           |
    | Minute        | 0-59                  | Minutes of the hour                               | \*           |
    | Hour          | 0-23                  | Hours of the day                                  | \*           |
    | Day of Month  | 1-31                  | Day in the month                                  | \*           |
    | Month         | 1-12 or JAN-DEC       | Month of the year                                 | \*           |
    | Day of Week   | 0-7 (0\/7 = SUN)      | Day in the week (0 or 7 represents Sunday)        | \*           |
     */

    /*

    | Operator | Description                                                               | Example                |
    |----------|---------------------------------------------------------------------------|------------------------|
    | \*       | All values. It means every value in the field.                           | \* (every minute)      |
    | /        | Increment: specify step values.                                          | /5 (every 5 minutes)  |
    | -        | Range of values.                                                         | 1-5 (minutes 1 to 5)   |
    | ,        | Lists: specify additional values.                                        | 1,3,5 (minutes 1,3 and 5)|
    | ?        | No specific value (used when a value is not required, mainly in day fields)| ? (either dayOfMonth or dayOfWeek) |
    | L        | Last, can be used in day fields to specify the last day of the month/week. | L (last day, e.g., of month) |
    | W        | Nearest weekday.                                                         | 15W (nearest weekday to the 15th) |
    | #        | Nth day-of-week: used for specifying the nth occurrence of a weekday      | 2#1 (first Monday of a month) |
   */
}
