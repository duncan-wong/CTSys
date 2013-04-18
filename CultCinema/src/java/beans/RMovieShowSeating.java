/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.accessInterface.UpdatableBean;

/**
 *
 * @author A
 */
public class RMovieShowSeating extends UpdatableBean {
    private String showing_id;
    private RSeat[][] seating_plan;
    private int rowCount;
    private int[] rowMax;
}
