enum Cube {
	RED, GREEN, BLUE

	static Cube parse(String text) {
		return values().find { text.contains(it.name().toLowerCase()) }
	}
}

class Game {
	int id
	List<Map<Cube, Integer>> shows

	int max(Cube cube) {
		return shows.collect { it.get(cube) }.max()
	}
}

String input = params.INPUT.trim()

List<Game> games = input.split("\n").collect { String game ->
	List<String> parts = game.split(":")

	List<Map<Cube, Integer>> shows = parts.last()
		.split(";")
		.collect { String show ->
			show.trim()
				.split(",")
				.collectEntries() { String cubes ->
					[Cube.parse(cubes.trim()), cubes.trim().split(" ").first().toInteger()]
				} as Map<Cube, Integer>
		}

	return new Game(id: parts.first().trim().split(" ").last().toInteger(), shows: shows)
}


int part1 = games.findAll { it.max(Cube.GREEN) <= 13 && it.max(Cube.RED) <= 12 && it.max(Cube.BLUE) <= 14 }.collect { it.id }.sum()
int part2 = games.collect { it.max(Cube.RED) * it.max(Cube.GREEN) * it.max(Cube.BLUE) }.sum()

println("Part 1: ${part1}")
println("Part 2: ${part2}")
