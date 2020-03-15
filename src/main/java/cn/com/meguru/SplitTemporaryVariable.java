package cn.com.meguru;

/**
 * 分解临时变量
 * @author jiaoziang
 * @date 2020/3/15
 */
public class SplitTemporaryVariable {


    private int primaryForce, mass, delay, secondaryForce;

    //----------------------------------------------------------------------------------------------
    /**
     * before
     * @return
     */
    public double getDistanceTravelled(int time) {
        double result;
        //f = ma
        double acceleration = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        //w = 1/2at^2
        result = 0.5 * acceleration * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            //v = at
            double primaryV = acceleration * delay;
            //a2 = (f1+f2)/m
            acceleration = (primaryForce + secondaryForce) / mass;
            //w = v0t + 1/2at^2
            result += primaryV * secondaryTime + 0.5 * acceleration * secondaryTime * secondaryTime;
        }
        return result;
    }

    //----------------------------------------------------------------------------------------------
    /**
     * after
     * @return
     */
    public double getDistanceTravelledN(int time) {
        double result;
        //f = ma
        final double primaryAcceleration = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        //w = 1/2at^2
        result = 0.5 * primaryAcceleration * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            //v = at
            double primaryV = primaryAcceleration * delay;
            //a2 = (f1+f2)/m
            final double secondaryAcceleration = (primaryForce + secondaryForce) / mass;
            //w = v0t + 1/2at^2
            result += primaryV * secondaryTime + 0.5 * secondaryAcceleration * secondaryTime * secondaryTime;
        }
        return result;
    }

    //----------------------------------------------------------------------------------------------
    /**
     * use replace temp with query
     * @return
     */
    public double getDistanceTravelledRTWQ(int time) {
        double result;
        //w = 1/2at^2
        result = 0.5 * getPrimaryAcceleration() * getPrimaryTime(time) * getPrimaryTime(time);
        if (getSecondaryTime(time) > 0) {
            //w = v0t + 1/2at^2
            result += getPrimaryV() * getSecondaryTime(time) + 0.5 * getSecondaryAcceleration() * getSecondaryTime(time) * getSecondaryTime(time);
        }
        return result;
    }

    private int getSecondaryAcceleration() {
        return (primaryForce + secondaryForce) / mass;
    }

    private double getPrimaryV() {
        return getPrimaryAcceleration() * delay;
    }

    private int getSecondaryTime(int time) {
        return time - delay;
    }

    private int getPrimaryTime(int time) {
        return Math.min(time, delay);
    }

    private int getPrimaryAcceleration() {
        return primaryForce / mass;
    }

    //----------------------------------------------------------------------------------------------
    /**
     * use explaining method/introduce explaining variable
     * @return
     */
    public double getDistanceTravelledEM(int time) {
        double result;
        result = getPrimaryDistanceTravelled(time);
        if (getSecondaryTime(time) > 0) {
            result += getSecondaryDistanceTravelled(time);
        }
        return result;
    }

    private double getSecondaryDistanceTravelled(int time) {
        return getPrimaryV() * getSecondaryTime(time) + 0.5 * getSecondaryAcceleration() * getSecondaryTime(time) * getSecondaryTime(time);
    }

    private double getPrimaryDistanceTravelled(int time) {
        return  0.5 * getPrimaryAcceleration() * getPrimaryTime(time) * getPrimaryTime(time);
    }

}
