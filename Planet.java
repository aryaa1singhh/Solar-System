class Planet {
    public static final int ROUND_VARIABLE = 1000;
    public static final double ROUND_VARIABLE_TWO = 1000.0;
    public static final double LUMINOSITY_CONSTANT = 0.75;
    public static final double HABITABLE_DISTANCE = 2.0;
    public static final double LOWER_LIMIT_MASS = 0.6;
    public static final double UPPER_LIMIT_MASS = 7.0;
    private String name; // name of planet
    private double distance; // distance from the star
    private double orbitalPeriod; // the time taken to orbit
    private double mass; //mass of planet
    private double radius; // radius of planet

    //constructor 1 for level 1 and 2
    Planet(String name, double distance) {
        this.name = name;
        this.distance = distance;
        this.orbitalPeriod = calculateOrbitalPeriod(distance);
    }
    //constructor 2 for level 3
    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
    }

      // constructor 3 for level 3
    Planet(String name, double mass, double radius, double distance) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
        this.distance = distance;
        this.orbitalPeriod = calculateOrbitalPeriod(distance);
    }

    // method to calculate the orbit period of planet
    public double calculateOrbitalPeriod(double distance) {
        return Math.sqrt(distance * distance * distance);
    }

    // method to return distance
    public double getDistance() {
        return distance;
    }
    // method to return name
    public String getName() {
        return name;
    }
    // method to return orbit period
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    // method to round to three figures
    public double round(double number) {
        double rounded = Math.round(number * ROUND_VARIABLE) / ROUND_VARIABLE_TWO;
        return rounded;
    }

    // method to give planets with same name and distance
    public boolean equals(Planet planet) {
        return planet.name.equals(this.name) && planet.distance == this.distance;
    }

    // method to calculate surface gravity
    public double surfaceGravity(){
        return mass/(radius * radius);
    }

     // method to establish condition for habitable
    public boolean isHabitable(double luminosity) {
        double luminosityFactor = Math.sqrt(luminosity);
        return (LUMINOSITY_CONSTANT * luminosityFactor <= distance && distance
                <= HABITABLE_DISTANCE * luminosityFactor)
                && (LOWER_LIMIT_MASS <= mass && mass <= UPPER_LIMIT_MASS);
    }

    public String getHabitable(double luminosity) {
        if (isHabitable(luminosity)) {
            return "yes";
        } else {
            return "no";
        }
    }

    public String toString() {
        if (radius == 0 && mass == 0){
            return (name + "  is " + round(distance)
                    + "AU from its star, and orbits in "
                    + round(orbitalPeriod) + " years");
        }else {
            return (name + " has a mass of " + round(mass)
                    + " Earths with a surface gravity of " +round(surfaceGravity())+"g, is "
                    + round(distance) + "AU from its star, and orbits in "
                    + round(orbitalPeriod) + " years: could be habitable? "
                    + getHabitable(SolarSystem.getLuminosity()));
        }
    }
}
