package tut.example.dota2Project.UI.Heroes.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "heroes")
data class Heroes(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val localized_name: String,
    val attack_type: String,
    val primary_attr: String,
    var img: String,
    val icon: String,
    val base_health: Int,
    val base_health_regen: Double,
    val base_mana: Int,
    val base_mana_regen: Double,
    val base_armor: Double,
    val base_attack_min: Int,
    val base_attack_max: Int,
    val base_str: Int,
    val base_agi: Int,
    val base_int: Int,
    val str_gain: Double,
    val agi_gain: Double,
    val int_gain: Double,
    val attack_range: Int,
    val move_speed: Double,

    val pro_pick: Int,
    @SerializedName("1_pick")
    val herald_pick: Int,

    @SerializedName("1_win")
    val herald_win: Int,

    @SerializedName("2_pick")
    val Guardian_picks: Int,

    @SerializedName("2_win")
    val Guardian_wins: Int,

    @SerializedName("3_pick")
    val Crusader_picks: Int,

    @SerializedName("3_win")
    val Crusader_wins: Int,

    @SerializedName("4_pick")
    val Archon_picks: Int,

    @SerializedName("4_win")
    val Archon_wins: Int,

    @SerializedName("5_pick")
    val Legend_picks: Int,

    @SerializedName("5_win")
    val Legend_wins: Int,

    @SerializedName("6_pick")
    val Ancient_picks: Int,

    @SerializedName("6_win")
    val Ancient_wins: Int,

    @SerializedName("7_pick")
    val Divine_picks: Int,

    @SerializedName("7_win")
    val Divine_wins: Int,

    @SerializedName("8_pick")
    val Immortal_picks: Int,

    @SerializedName("8_win")
    val Immortal_wins: Int,

    val turbo_pick: Int,
    val turbo_win: Int,

    ) : Serializable