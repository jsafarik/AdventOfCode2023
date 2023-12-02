pipelineJob('day-01') {
	parameters {
		textParam('INPUT', "", "Puzzle input")
	}
	definition {
		cps {
			script(readFileFromWorkspace("jobs/day-01/pipeline.groovy"))
			sandbox(true)
		}
	}
}
