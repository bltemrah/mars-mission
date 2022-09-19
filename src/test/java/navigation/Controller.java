package navigation;

public class Controller {

    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;

    static Integer x = 0;
    static Integer y = 0;
    static Integer facing = N;

    public int maxX;
    public int maxY;

    // created two boolean flag for the out of boundary coordination test scenarios
    public boolean flagOutOfBoundary = true;
    public boolean flagNegativeCoordination = true;

    public Controller() {
    }

    public void setPosition(Integer x, Integer y, Integer facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;

    // the below condition created for the negative test scenario assertion in the step definition
        if (x<0 || y<0) {
            flagNegativeCoordination=false;
        }
    }

    public int getAxisX() {
        return this.x;
    }

    public int getAxisY() {
        return this.y;
    }

    public int getDirection() {
        return this.facing;
    }

    public static String getPosition() {
        char direction = 'N';
        if (facing == 1) {
            direction = 'N';
        } else if (facing == 2) {
            direction = 'E';
        } else if (facing == 3) {
            direction = 'S';
        } else if (facing == 4) {
            direction = 'W';
        }
        String position = String.valueOf(x) + " " + String.valueOf(y) + " " + direction;

        return position;
    }

    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++) {
          if(flagOutOfBoundary) {
              process(commands.charAt(idx));
          } else {
              break;
          }
        }
    }

    private void process(Character command) {
        // the below condition created for the negative test scenario assertion in the step definition
        if (y>maxY || x>maxX || x<0 || y<0) {
                flagOutOfBoundary = false;
                System.out.println("Rover can not move out of coordination boundary");
        } else {
            if (command.equals('L')) {
                turnLeft();
            } else if (command.equals('R')) {
                turnRight();
            } else if (command.equals('M')) {
                move(1);
            } else if (command.equals("B")) {
                turnBack();
            } else {
                throw new IllegalArgumentException(
                        "Speak in Mars language, please!");
            }
        }
    }
    public void move(int distance) {
        if (facing == N) {
            this.y = y + distance;
            System.out.println("The rover moving distance is "
                    + distance + " units to North " + "(" + getPosition() + ")");
        } else if (facing == E) {
            this.x = x + distance;
            System.out.println("The rover moving distance is " + distance
                    + " units to East " + "(" + getPosition() + ")");
        } else if (facing == S) {
            this.y = y - distance;
            System.out.println("The rover moving distance is " + distance
                    + " units to South " + "(" + getPosition() + ")");
        } else if (facing == W) {
            this.x = x - distance;
            System.out.println("The rover moving distance is " + distance
                    + " units to West " + "(" + getPosition() + ")");
        }
    }

    public void turnLeft() {
        facing = (facing - 1) < N ? W : facing - 1;
        System.out.println("Turn: The rover has turned left "
                + "(" + getPosition() + ")");
    }

    public void turnRight() {
        facing = (facing + 1) > W ? N : facing + 1;
        System.out.println("Turn: The rover has turned right "
                + "(" + getPosition() + ")");
    }

    public void turnBack() {
        switch (facing) {
            case 1:
                facing = S;
                break;
            case 2:
                facing = W;
                break;
            case 3:
                facing = N;
                break;
            case 4:
                facing = E;
                break;
        }
        System.out.println("The rover has turned back "
                + "(" + getPosition() + ")");
    }

    public void coordinationSize(Integer x, Integer y) {
        maxX = x;
        maxY = y;

    }
    //    because no need to run anything in this class, removed the main method
}

