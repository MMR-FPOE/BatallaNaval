package com.example.navalbattle.model;

import java.util.ArrayList;
import java.util.Random;

public class ComputerBoard {

    private ArrayList<ArrayList<Character>> matriz = new ArrayList<>();

    Ship ship = new Ship();
    AircraftCarrier aircraft = new AircraftCarrier();
    Destroyer destroyer = new Destroyer();
    Frigate frigate = new Frigate();
    Submarine submarine = new Submarine();

    public ComputerBoard(){

    }

    public void setFirstPosition(){

        ArrayList<Coordinate>  ac = new ArrayList<>();
        ac.add(new Coordinate(0, 6));
        ac.add(new Coordinate(0, 7));
        ac.add(new Coordinate(0, 8));
        ac.add(new Coordinate(0, 9));
        aircraft.setPositions(ac);

        ArrayList<Coordinate>  sub = new ArrayList<>();
        sub.add(new Coordinate(2, 2));
        sub.add(new Coordinate(3, 2));
        sub.add(new Coordinate(4, 2));
        submarine.setPositions(sub);

        ArrayList<Coordinate> sub1 = new ArrayList<>();
        sub1.add(new Coordinate(4, 6));
        sub1.add(new Coordinate(4, 7));
        sub1.add(new Coordinate(4, 8));
        submarine.setPositions(sub1);

        ArrayList<Coordinate> dest = new ArrayList<>();
        dest.add(new Coordinate(8, 9));
        dest.add(new Coordinate(9,9));
        destroyer.setPositions(dest);

        ArrayList<Coordinate> dest1 = new ArrayList<>();
        dest1.add(new Coordinate(6, 4));
        dest1.add(new Coordinate(6,5));
        destroyer.setPositions(dest1);

        ArrayList<Coordinate> dest2 = new ArrayList<>();
        dest2.add(new Coordinate(4, 0));
        dest2.add(new Coordinate(5,0));
        destroyer.setPositions(dest2);

        ArrayList<Coordinate> frag = new ArrayList<>();
        frag.add(new Coordinate(8, 1));
        frigate.setPositions(frag);

        ArrayList<Coordinate> frag1 = new ArrayList<>();
        frag1.add(new Coordinate(8, 0));
        frigate.setPositions(frag1);

        ArrayList<Coordinate> frag2 = new ArrayList<>();
        frag2.add(new Coordinate(0, 3));
        frigate.setPositions(frag2);

        ArrayList<Coordinate> frag3 = new ArrayList<>();
        frag3.add(new Coordinate(2, 5));
        frigate.setPositions(frag3);

    }

    public void setSecondPosition(){

        ArrayList<Coordinate> S_ac = new ArrayList<>();
        S_ac.add(new Coordinate(4, 5));
        S_ac.add(new Coordinate(5, 5));
        S_ac.add(new Coordinate(6, 5));
        S_ac.add(new Coordinate(7, 5));
        aircraft.setPositions(S_ac);

        ArrayList<Coordinate>  S_sub = new ArrayList<>();
        S_sub.add(new Coordinate(1, 6));
        S_sub.add(new Coordinate(1, 7));
        S_sub.add(new Coordinate(1, 8));
        submarine.setPositions(S_sub);

        ArrayList<Coordinate> S_sub1 = new ArrayList<>();
        S_sub1.add(new Coordinate(4, 2));
        S_sub1.add(new Coordinate(5, 2));
        S_sub1.add(new Coordinate(6, 2));
        submarine.setPositions(S_sub1);

        ArrayList<Coordinate> S_dest = new ArrayList<>();
        S_dest.add(new Coordinate(2, 0));
        S_dest.add(new Coordinate(2,1));
        destroyer.setPositions(S_dest);

        ArrayList<Coordinate> S_dest1 = new ArrayList<>();
        S_dest1.add(new Coordinate(1, 3));
        S_dest1.add(new Coordinate(1,4));
        destroyer.setPositions(S_dest1);

        ArrayList<Coordinate> S_dest2 = new ArrayList<>();
        S_dest2.add(new Coordinate(6, 8));
        S_dest2.add(new Coordinate(7,8));
        destroyer.setPositions(S_dest2);

        ArrayList<Coordinate> S_frag = new ArrayList<>();
        S_frag.add(new Coordinate(8, 8));
        frigate.setPositions(S_frag);

        ArrayList<Coordinate> S_frag1 = new ArrayList<>();
        S_frag1.add(new Coordinate(0, 0));
        frigate.setPositions(S_frag1);

        ArrayList<Coordinate> S_frag2 = new ArrayList<>();
        S_frag2.add(new Coordinate(3, 8));
        frigate.setPositions(S_frag2);

        ArrayList<Coordinate> S_frag3 = new ArrayList<>();
        S_frag3.add(new Coordinate(7, 0));
        frigate.setPositions(S_frag3);
    }

    public void setThirdPosition(){

        ArrayList<Coordinate> T_ac2 = new ArrayList<>();
        T_ac2.add(new Coordinate(6, 4));
        T_ac2.add(new Coordinate(6, 5));
        T_ac2.add(new Coordinate(6, 6));
        T_ac2.add(new Coordinate(6, 7));
        aircraft.setPositions(T_ac2);

        ArrayList<Coordinate> T_sub = new ArrayList<>();
        T_sub.add(new Coordinate(9, 0));
        T_sub.add(new Coordinate(9, 1));
        T_sub.add(new Coordinate(9, 2));
        submarine.setPositions(T_sub);

        ArrayList<Coordinate> T_sub1 = new ArrayList<>();
        T_sub1.add(new Coordinate(3, 7));
        T_sub1.add(new Coordinate(3, 8));
        T_sub1.add(new Coordinate(3, 9));
        submarine.setPositions(T_sub1);

        ArrayList<Coordinate> T_dest = new ArrayList<>();
        T_dest.add(new Coordinate(3, 1));
        T_dest.add(new Coordinate(4,1));
        destroyer.setPositions(T_dest);

        ArrayList<Coordinate> T_dest1 = new ArrayList<>();
        T_dest1.add(new Coordinate(4, 4));
        T_dest1.add(new Coordinate(4,5));
        destroyer.setPositions(T_dest1);

        ArrayList<Coordinate> T_dest2 = new ArrayList<>();
        T_dest2.add(new Coordinate(9, 7));
        T_dest2.add(new Coordinate(9,8));
        destroyer.setPositions(T_dest2);

        ArrayList<Coordinate> T_frag = new ArrayList<>();
        T_frag.add(new Coordinate(1, 5));
        frigate.setPositions(T_frag);

        ArrayList<Coordinate> T_frag1 = new ArrayList<>();
        T_frag1.add(new Coordinate(7, 9));
        frigate.setPositions(T_frag1);

        ArrayList<Coordinate> T_frag2 = new ArrayList<>();
        T_frag2.add(new Coordinate(6, 1));
        frigate.setPositions(T_frag2);

        ArrayList<Coordinate> T_frag3 = new ArrayList<>();
        T_frag3.add(new Coordinate(2, 1));
        frigate.setPositions(T_frag3);

    }

    public void setMatriz() {
        Random random = new Random();
        int position = random.nextInt(4);

        ArrayList<ArrayList<Coordinate>> actualPositionsArray;

        switch(position){
            case 0:
                setFirstPosition();
                actualPositionsArray = ship.getPositions();

                break;
            case 1:
                setSecondPosition();
                break;
            case 2:
                setThirdPosition();
                break;
        }

    }

    //terminar
    public void fillMatriz(ArrayList<ArrayList<Coordinate>> actualPositions){
        ArrayList<Character> fila  = new ArrayList<>();
        char row, column;

        for(int i=0; i < actualPositions.size(); i++) {
            ArrayList<Coordinate> rowCoordinates = actualPositions.get(i);
            for (Coordinate coord : rowCoordinates) {
                row = coord.getCharRow();
                column = coord.getCharColumn();
            }
        }
    }

    public void trowBomb(){
        Random random = new Random();
        int row = random.nextInt(10);
        int column = random.nextInt(10);
    }
}
