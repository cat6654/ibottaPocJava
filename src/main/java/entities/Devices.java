
package entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "com.apple.CoreSimulator.SimRuntime.iOS-13-1",
    "com.apple.CoreSimulator.SimRuntime.iOS-12-4",
    "com.apple.CoreSimulator.SimRuntime.watchOS-6-0",
    "com.apple.CoreSimulator.SimRuntime.tvOS-13-0"
})
public class Devices {

    @JsonProperty("com.apple.CoreSimulator.SimRuntime.iOS-13-1")
    private List<ComAppleCoreSimulatorSimRuntimeIOS131> comAppleCoreSimulatorSimRuntimeIOS131 = null;
    @JsonProperty("com.apple.CoreSimulator.SimRuntime.iOS-12-4")
    private List<ComAppleCoreSimulatorSimRuntimeIOS124> comAppleCoreSimulatorSimRuntimeIOS124 = null;
    @JsonProperty("com.apple.CoreSimulator.SimRuntime.watchOS-6-0")
    private List<ComAppleCoreSimulatorSimRuntimeWatchOS60> comAppleCoreSimulatorSimRuntimeWatchOS60 = null;
    @JsonProperty("com.apple.CoreSimulator.SimRuntime.tvOS-13-0")
    private List<ComAppleCoreSimulatorSimRuntimeTvOS130> comAppleCoreSimulatorSimRuntimeTvOS130 = null;

    @JsonProperty("com.apple.CoreSimulator.SimRuntime.iOS-13-1")
    public List<ComAppleCoreSimulatorSimRuntimeIOS131> getComAppleCoreSimulatorSimRuntimeIOS131() {
        return comAppleCoreSimulatorSimRuntimeIOS131;
    }

    @JsonProperty("com.apple.CoreSimulator.SimRuntime.iOS-13-1")
    public void setComAppleCoreSimulatorSimRuntimeIOS131(List<ComAppleCoreSimulatorSimRuntimeIOS131> comAppleCoreSimulatorSimRuntimeIOS131) {
        this.comAppleCoreSimulatorSimRuntimeIOS131 = comAppleCoreSimulatorSimRuntimeIOS131;
    }

    @JsonProperty("com.apple.CoreSimulator.SimRuntime.iOS-12-4")
    public List<ComAppleCoreSimulatorSimRuntimeIOS124> getComAppleCoreSimulatorSimRuntimeIOS124() {
        return comAppleCoreSimulatorSimRuntimeIOS124;
    }

    @JsonProperty("com.apple.CoreSimulator.SimRuntime.iOS-12-4")
    public void setComAppleCoreSimulatorSimRuntimeIOS124(List<ComAppleCoreSimulatorSimRuntimeIOS124> comAppleCoreSimulatorSimRuntimeIOS124) {
        this.comAppleCoreSimulatorSimRuntimeIOS124 = comAppleCoreSimulatorSimRuntimeIOS124;
    }

    @JsonProperty("com.apple.CoreSimulator.SimRuntime.watchOS-6-0")
    public List<ComAppleCoreSimulatorSimRuntimeWatchOS60> getComAppleCoreSimulatorSimRuntimeWatchOS60() {
        return comAppleCoreSimulatorSimRuntimeWatchOS60;
    }

    @JsonProperty("com.apple.CoreSimulator.SimRuntime.watchOS-6-0")
    public void setComAppleCoreSimulatorSimRuntimeWatchOS60(List<ComAppleCoreSimulatorSimRuntimeWatchOS60> comAppleCoreSimulatorSimRuntimeWatchOS60) {
        this.comAppleCoreSimulatorSimRuntimeWatchOS60 = comAppleCoreSimulatorSimRuntimeWatchOS60;
    }

    @JsonProperty("com.apple.CoreSimulator.SimRuntime.tvOS-13-0")
    public List<ComAppleCoreSimulatorSimRuntimeTvOS130> getComAppleCoreSimulatorSimRuntimeTvOS130() {
        return comAppleCoreSimulatorSimRuntimeTvOS130;
    }

    @JsonProperty("com.apple.CoreSimulator.SimRuntime.tvOS-13-0")
    public void setComAppleCoreSimulatorSimRuntimeTvOS130(List<ComAppleCoreSimulatorSimRuntimeTvOS130> comAppleCoreSimulatorSimRuntimeTvOS130) {
        this.comAppleCoreSimulatorSimRuntimeTvOS130 = comAppleCoreSimulatorSimRuntimeTvOS130;
    }
}
