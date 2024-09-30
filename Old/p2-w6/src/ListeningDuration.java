
enum ListeningDuration {
    YET_TO_LISTEN,
    // Listened for less than 1 minute
    UNDER_1_MINUTE,
    // Listened for more than a minute but up to a quarter of the track's duration
    ONE_QUARTER,
    // Listened for more than a quarter but up to half of the track's duration
    HALF,
    // Listened for more than a half but up to 3 quarters of the track's duration
    THREE_QUARTERS,
    // Listened for the whole duration of the track
    WHOLE_DURATION
}