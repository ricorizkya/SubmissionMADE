package com.example.submissionjetpackpro.utils

import com.example.submissionjetpackpro.data.local.model.MoviesEntity
import com.example.submissionjetpackpro.data.local.model.TVShowsEntity
import com.example.submissionjetpackpro.data.remote.genre.GenreResponse
import com.example.submissionjetpackpro.data.remote.movies.MoviesDataResponse
import com.example.submissionjetpackpro.data.remote.tvshows.TVShowsDataResponse

object DataDummy {

    /**MOVIES**/
    fun getMovies(): List<MoviesEntity> {
        val movies = ArrayList<MoviesEntity>()
        movies.add(
            MoviesEntity(
                337404,
                "Cruella",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with designs. She befriends a pair of young thieves" +
                    "who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets." +
                    "One day, Estella's flair for fashion cathces the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifungly haute." +
                    "But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
//                "Comedy, Crime",
                "2021-05-26",
                "8.6",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg"
            )
        )

        movies.add(
            MoviesEntity(
                423108,
                "The Conjuring: The Devil Made Me Do It",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. " +
                        "The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
//                "Comedy, Crime",
                "2021-05-25",
                "8.2",
                "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg"
            )
        )

        movies.add(
            MoviesEntity(
                637649,
                "Wrath of Man",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. " +
                        "The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
//                "Comedy, Crime",
                "2021-04-22",
                "7.9",
                "/M7SUK85sKjaStg4TKhlAVyGlz3.jpg"
            )
        )

        movies.add(
            MoviesEntity(
                632357,
                "The Unholy",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. " +
                        "As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. " +
                        "When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
//                "Comedy, Crime",
                "2021-03-31",
                "7.1",
                "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg"
            )
        )

        movies.add(
            MoviesEntity(
                817451,
                "Endangered Species",
                "Jack Halsey takes his wife, their adult kids, and a friend for a dream vacation in Kenya. But as they venture off alone into a wilderness park, " +
                        "their safari van is flipped over by an angry rhino, leaving them injured and desperate. Then, as two of them go in search of rescue, a bloody, vicious encounter with a leopard and a clan of hyenas incites a desperate fight for survival.",
//                "Comedy, Crime",
                "2021-05-27",
                "7.2",
                "/ccsSqbpEqr2KK9eMvoeF8ERFCd5.jpg"
            )
        )
        return movies
    }

    fun getMoviesRemote(): ArrayList<MoviesEntity> {
        val moviesRemote = ArrayList<MoviesEntity>()
        moviesRemote.add(
            MoviesEntity(
                337404,
                "Cruella",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with designs. She befriends a pair of young thieves" +
                        "who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets." +
                        "One day, Estella's flair for fashion cathces the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifungly haute." +
                        "But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
//                "Comedy, Crime",
                "2021-05-26",
                "8.6",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg"
            )
        )

        moviesRemote.add(
            MoviesEntity(
                423108,
                "The Conjuring: The Devil Made Me Do It",
                "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. " +
                        "The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
//                "Comedy, Crime",
                "2021-05-25",
                "8.2",
                "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg"
            )
        )

        moviesRemote.add(
            MoviesEntity(
                637649,
                "Wrath of Man",
                "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. " +
                        "The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
//                "Comedy, Crime",
                "2021-04-22",
                "7.9",
                "/M7SUK85sKjaStg4TKhlAVyGlz3.jpg"
            )
        )

        moviesRemote.add(
            MoviesEntity(
                632357,
                "The Unholy",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. " +
                        "As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. " +
                        "When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
//                "Comedy, Crime",
                "2021-03-31",
                "7.1",
                "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg"
            )
        )

        moviesRemote.add(
            MoviesEntity(
                817451,
                "Endangered Species",
                "Jack Halsey takes his wife, their adult kids, and a friend for a dream vacation in Kenya. But as they venture off alone into a wilderness park, " +
                        "their safari van is flipped over by an angry rhino, leaving them injured and desperate. Then, as two of them go in search of rescue, a bloody, vicious encounter with a leopard and a clan of hyenas incites a desperate fight for survival.",
//                "Comedy, Crime",
                "2021-05-27",
                "7.2",
                "/ccsSqbpEqr2KK9eMvoeF8ERFCd5.jpg"
            )
        )
        return moviesRemote
    }

    fun getMoviesDetail(id: Int): MoviesEntity {
        return MoviesEntity(
            337404,
            "Cruella",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with designs. " +
                    "She befriends a pair of young thieveswho appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets." +
                    "One day, Estella's flair for fashion cathces the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifungly haute.But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
//            "Comedy, Crime",
            "2021-05-26",
            "8.6",
            "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg"
        )
    }

    fun getMoviesDetailRemote(id: Int): MoviesDataResponse {
        return MoviesDataResponse(
            33740,
            "Cruella",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. " +
                    "She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. " +
                    "One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            listOf(
                GenreResponse(35, "Comedy"),
                GenreResponse(80, "Crime")
            ),
            "2021-05-26",
            "8.6",
            "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg"
        )
    }

    /**TV SHOWS**/
    fun getTVShows(): List<TVShowsEntity> {
        val tvShows = ArrayList<TVShowsEntity>()
        tvShows.add(
            TVShowsEntity(
                84958,
                "Grey's Anatomy",
                "Follow the personal and professional lives of a group of doctors at Seattle's Grey Sloan Memorial Hospital.",
//                "Comedy, Crime",
                "2005-03-37",
                "8.2",
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg"
            )
        )

        tvShows.add(
            TVShowsEntity(
                63174,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
//                "Comedy, Crime",
                "2016-01-25",
                "8.5",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
            )
        )

        tvShows.add(
            TVShowsEntity(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, " +
                        "granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was " +
                        "created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close " +
                        "friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
//                "Comedy, Crime",
                "2014-10-07",
                "7.7",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )

        tvShows.add(
            TVShowsEntity(
                103768,
                "Sweet Tooth",
                "On a perilous adventure across a post-apocalyptic world, a lovable boy who's half-human and half-deer searches for a new beginning with a gruff protector.",
//                "Comedy, Crime",
                "2021-06-04",
                "8",
                "/rgMfhcrVZjuy5b7Pn0KzCRCEnMX.jpg"
            )
        )

        tvShows.add(
            TVShowsEntity(
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
//                "Comedy, Crime",
                "2017-09-25",
                "8.6",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )
        return tvShows
    }

    fun getTVShowsRemote(): ArrayList<TVShowsEntity> {
        val tvShowsRemote = ArrayList<TVShowsEntity>()
        tvShowsRemote.add(
            TVShowsEntity(
                84958,
                    "Grey's Anatomy",
                    "Follow the personal and professional lives of a group of doctors at Seattle's Grey Sloan Memorial Hospital.",
//                "Comedy, Crime",
                    "2005-03-37",
                    "8.2",
                "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg"
            )
        )

        tvShowsRemote.add(
            TVShowsEntity(
                63174,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
//                "Comedy, Crime",
                "2016-01-25",
                "8.5",
                "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
            )
        )

        tvShowsRemote.add(
            TVShowsEntity(60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, " +
                        "granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was " +
                        "created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close " +
                        "friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
//                "Comedy, Crime",
                "2014-10-07",
                "7.7",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg")
        )

        tvShowsRemote.add(
            TVShowsEntity(103768,
                "Sweet Tooth",
                "On a perilous adventure across a post-apocalyptic world, a lovable boy who's half-human and half-deer searches for a new beginning with a gruff protector.",
//                "Comedy, Crime",
                "2021-06-04",
                "8",
                "/rgMfhcrVZjuy5b7Pn0KzCRCEnMX.jpg")
        )

        tvShowsRemote.add(
            TVShowsEntity(
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
//                "Comedy, Crime",
                "2017-09-25",
                "8.6",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )
        return tvShowsRemote
    }

    fun getTVShowsDetail(id: Int): TVShowsEntity {
        return TVShowsEntity(
            84958,
                "Grey's Anatomy",
                "Follow the personal and professional lives of a group of doctors at Seattle's Grey Sloan Memorial Hospital.",
//                "Comedy, Crime",
                "2005-03-37",
                "8.2",
            "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg"
        )
    }

    fun getTVShowsDetailREmote(id: Int): TVShowsDataResponse {
        return TVShowsDataResponse(
            84958,
            "Loki",
            "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, " +
                    "a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
            listOf(
                GenreResponse(10759, "Action & Adventure"),
                GenreResponse(10765, "Sci-Fi & Fantasy")
            ),
            "2021-06-09",
            "8.1",
            "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg"
        )
    }
}
