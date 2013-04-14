/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author DUNCAN
 */


//collection of RMovie objects
public class RMovieCol {
    private ArrayList<RMovie> movieCol;
//-----------------------------------------------------------------------------
    public RMovieCol() {
        movieCol = new ArrayList<RMovie>();
    }
//-----------------------------------------------------------------------------
    public void add(RMovie r) {
        movieCol.add(r);
    }
    public RMovie[] getAll() {
        return movieCol.toArray(new RMovie[movieCol.size()]);
    }
    public RMovie getAt(int i) {
        return movieCol.get(i);
    }
}
