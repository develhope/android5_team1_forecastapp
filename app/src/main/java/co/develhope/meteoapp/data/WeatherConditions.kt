package co.develhope.meteoapp.data

data class WeatherConditions(
    var latitude : Float,
    var longitude : Float,
    var elevation : Float,
    var hourly : Array<String>,
    var daily : String,
    var current_weather : Boolean,
    var temperature_unit : String,
    var windspeed_unit : String,
    var precipitation_unit : String,
    var timeformat : String,
    var timezone : String,
    var past_days : Int,
    var forecast_days : Int,
    var start_date : String,
    var end_date : String,
    var models : String,
    var cell_selection : String,
    var isExpanded: Boolean = false
)
