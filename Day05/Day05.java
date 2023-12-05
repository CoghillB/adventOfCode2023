package Day05;
import java.util.*;
import java.io.IOException;
import AdventUtilities.*;

import java.util.*;

public class Day05 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> input = AdventUtilities.readLines("Day05/Day05.txt");
        int minLocation = getMinLocation(input);
        System.out.println(minLocation);
    }

    private static int getMinLocation(List<String> inputLines) {
        // Parse the input to get the initial seeds and the maps.
		List<Integer> initialSeeds = new ArrayList<>();
		Map<Integer, Integer> seedToSoilMap = new HashMap<>();
		Map<Integer, Integer> soilToFertilizerMap = new HashMap<>();
		Map<Integer, Integer> fertilizerToWaterMap = new HashMap<>();
		Map<Integer, Integer> waterToLightMap = new HashMap<>();
		Map<Integer, Integer> lightToTemperatureMap = new HashMap<>();
		Map<Integer, Integer> temperatureToHumidityMap = new HashMap<>();
		Map<Integer, Integer> humidityToLocationMap = new HashMap<>();

        int minLocation = Integer.MAX_VALUE;
        for (int seed : initialSeeds) {
            int soil = convert(seed, seedToSoilMap);
            int fertilizer = convert(soil, soilToFertilizerMap);
            int water = convert(fertilizer, fertilizerToWaterMap);
            int light = convert(water, waterToLightMap);
            int temperature = convert(light, lightToTemperatureMap);
            int humidity = convert(temperature, temperatureToHumidityMap);
            int location = convert(humidity, humidityToLocationMap);
            minLocation = Math.min(minLocation, location);
        }
        return minLocation;
    }

    private static int convert(int source, Map<Integer, Integer> map) {
		if (!map.containsKey(source)) {
			int converted = convert(source, map);
			map.put(source, converted);
		}
        return map.getOrDefault(source, source);
    }
}