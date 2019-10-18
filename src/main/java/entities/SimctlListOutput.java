
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
    "devicetypes",
    "runtimes",
    "devices",
    "pairs"
})
public class SimctlListOutput {

    @JsonProperty("devicetypes")
    private List<Devicetype> devicetypes = null;
    @JsonProperty("runtimes")
    private List<Runtime> runtimes = null;
    @JsonProperty("devices")
    private Devices devices;
    @JsonProperty("pairs")
    private Pairs pairs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("devicetypes")
    public List<Devicetype> getDevicetypes() {
        return devicetypes;
    }

    @JsonProperty("devicetypes")
    public void setDevicetypes(List<Devicetype> devicetypes) {
        this.devicetypes = devicetypes;
    }

    @JsonProperty("runtimes")
    public List<Runtime> getRuntimes() {
        return runtimes;
    }

    @JsonProperty("runtimes")
    public void setRuntimes(List<Runtime> runtimes) {
        this.runtimes = runtimes;
    }

    @JsonProperty("devices")
    public Devices getDevices() {
        return devices;
    }

    @JsonProperty("devices")
    public void setDevices(Devices devices) {
        this.devices = devices;
    }

    @JsonProperty("pairs")
    public Pairs getPairs() {
        return pairs;
    }

    @JsonProperty("pairs")
    public void setPairs(Pairs pairs) {
        this.pairs = pairs;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
