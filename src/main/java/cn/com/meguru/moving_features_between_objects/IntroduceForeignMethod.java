package cn.com.meguru.moving_features_between_objects;

import java.util.Date;

/**
 * 引入外加函数
 * @author jiaoziang
 * @date 2020/3/23
 */
public class IntroduceForeignMethod {

    /**
     * before
     * @param previousEnd
     * @return
     */
    Date getNewStart(Date previousEnd) {
        return new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);
    }

    /**
     * after
     * @param previousEnd
     * @return
     */
    Date getNewStartN(Date previousEnd) {
        return nextDay(previousEnd);
    }

    private static Date nextDay(Date date) {
        return new Date(date.getYear(), date.getMonth(), date.getDate());
    }

}
