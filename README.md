Code Structure As Follows-

Architecture - MVP
Language - Kotlin
Http Client - Retrofit

Below is the flow for the same:

1. As soon as the app launcher is show to the user.
2. In the background we try to fetch data from the DB via Repository(model) which is our single source of truth.
3. If the data is not available in the DB we make a Api call through our fetcher in the repository which pulls the data through the server using retrofit.
4. We save this data and pass the  result to our presenter.
5. The presenter then passes the fetched response to our adapter factory which is responsible to adapt the fetched data to our model.
6. The result returned by the adapter factory is passed to our view which passes it to the recyclerview adapter which render the layout.
7. In the recycler view holders we have used abstraction and view holder factory to scale if in future any more view types come in.
8. Whenever an item is selected a callback is passed to the presenter which decides and executes the exclusion rules and disables the option if required.

To Sync data every 24 hours a work manager is used which sync and updates data in the DB.

Apart from this for DB Sql lite is used.
GSon is used to convertor in retrofit and to parse json.
