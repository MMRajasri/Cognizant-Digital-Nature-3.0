public class CommandPatternTest {
    public static void main(String[] args) {
        // Create the receiver object
        Light livingRoomLight = new Light();

        // Create command objects and pass the receiver to them
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Create the invoker object
        RemoteControl remote = new RemoteControl();

        // Turn on the light
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn off the light
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
