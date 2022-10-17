package com.chacon.axel.tecsupfy

class SongRepository (val songs: MutableList<Song> = ArrayList()){

    init{
        getDataSongs()
    }

    fun getDataSongs(): List<Song>{
        songs.add(Song(100, "Unseen Skies", "2045, a r u k a., fungeey", "Electronica", "4:14", "cover_unseenskies"))
        songs.add(Song(200, "Gather the Lights", "JYOCHO", "Rock", "4:11", "cover_gatherthelights"))
        songs.add(Song(300, "No Exit", "a picture of her", "Rock", "4:13", "cover_noexit"))
        songs.add(Song(400, "safe with me", "shameless.", "Rock", "4:15", "cover_safewithme"))
        songs.add(Song(500, "verdant", "xaev", "Rock", "3:49", "cover_verdant"))
        songs.add(Song(600, "falling through the clouds", "tokimi", "Electronica", "1:49", "cover_fallingthroughtheclouds"))
        songs.add(Song(700, "Paper cup telephone", "D'art -, aquoferne", "Electronica", "5:07", "cover_papercuptelephone"))
        songs.add(Song(800, "melting oceans", "emulaation, 2045", "Rock", "4:11", "cover_meltingoceans"))
        return songs
    }
}