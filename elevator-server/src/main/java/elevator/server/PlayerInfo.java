package elevator.server;

import elevator.FloorState;

import java.io.Serializable;
import java.util.Set;

class PlayerInfo implements Serializable {
    public final String pseudo;
    public final String email;
    public final int score;
    public final int averageScore;
    public final int elevatorAtFloor;
    public final long peopleInTheElevator;
    public final boolean doorIsOpen;
    public final String lastErrorMessage;
    public final String state;
    public final Set<FloorState> floorStates;

    PlayerInfo(ElevatorGame game, Player player) {
        email = player.email;
        pseudo = player.pseudo;
        score = game.score();
        averageScore = game.averageScore();
        elevatorAtFloor = game.floor();
        peopleInTheElevator = game.travelingUsers();
        doorIsOpen = game.doorIsOpen();
        lastErrorMessage = game.lastErrorMessage;
        state = game.state.toString();
        floorStates = game.floorStates();
    }
}
