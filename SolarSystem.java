import java.util.ArrayList;

//created class SolarSystem
class SolarSystem{
    private String name; // name of the star
    private ArrayList<Planet> planets; // arraylist of all the planets
    private static double luminosity; // luminosity of the planet

    //constructor 1
     SolarSystem(String name){
        this.name = name;
        this.planets = new ArrayList<>();
    }
     // constructor 2
     SolarSystem(String name, double luminosity) {
        this.name = name;
        SolarSystem.luminosity = luminosity;
        this.planets = new ArrayList<>();
    }

   // defining method to get luminosity
    public static double getLuminosity() {
        return luminosity;
    }
    // defining method to add planet level 1 and 2
    public void addPlanet(String name, double distance){
        Planet planet1 = new Planet(name, distance);
        planets.add(planet1);

    }
    // defining method to add planet level 3
    public void addPlanet(String name, double mass, double radius, double distance) {
        Planet planet1 = new Planet(name, mass, radius, distance);
        planets.add(planet1);
    }

    // defining method to get planet by specifying name
    public Planet getPlanetByName(String name) {
        for (Planet planet : planets) {
            if (planet.getName().equals(name)) {
                return planet;
            }
        }
        return null;
    }

    // method to get the farthest planet from star
    public Planet furthest(){
        if (planets.isEmpty()) {
            return null;
        }
        Planet furthestPlanet = planets.get(0);
        for (Planet planet : planets){
            if (planet.getDistance() > furthestPlanet.getDistance()){
                furthestPlanet = planet;
            }
        }
        return furthestPlanet;
    }

    // method to get nearest planet to the star
    public Planet closest(){
        if (planets.isEmpty()) {
            return null;
        }
        Planet closestPlanet = planets.get(0);
        for (Planet planet : planets){
            if (planet.getDistance() < closestPlanet.getDistance()){
                closestPlanet = planet;
            }
        }
        return closestPlanet;
    }


    public String toString(){
        String output = ("Star " + name + " has planets:\n");
        for (int i = 0; i < planets.size(); i++) {
            Planet planet = planets.get(i);
            output += planet.toString() +"\n";
        }
        return output;
    }
}
