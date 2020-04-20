/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processSupport;

import java.util.Date;

/**
 *
 * @author green
 */
public class Supporter {

    public long getCurrentTime() {
        Date date = new Date();
        return date.getTime() / 1000;
    }

    public long getEndingTime(long totalTime) {
        return getCurrentTime() + totalTime;
    }

}
