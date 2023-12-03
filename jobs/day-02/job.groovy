import parameters.Parameter
import parameters.ParameterType

pipelineJob('day-02') {
	parameters ParameterType.getParametersClosure(Parameter.INPUT)
	definition {
		cps {
			script(readFileFromWorkspace("jobs/day-02/pipeline.groovy"))
			sandbox(true)
		}
	}
}
