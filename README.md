# Spot News APP

The App displays news from [News API](https://newsapi.org/).

## How TO Run

The App uses [Secrets Gradle](https://developers.google.com/maps/documentation/android-sdk/secrets-gradle-plugin) Plugin to hide the news API key.

Add `NEWS_API_KEY=your-api-key` to your **local.properties** gradle file.

We can point to the API key in the code by using
> BuildConfig.NEWS_API_KEY
