pipelineJob('day-02') {
	parameters {
		textParam('INPUT', "", "Puzzle input")
	}
	definition {
		cps {
			script(readFileFromWorkspace("jobs/day-02/pipeline.groovy"))
			sandbox(true)
		}
	}
}
