package com.project.radiusagentassignment.models

data class FacilitiesAPIModel constructor(val id: String) {
    val facilities: ArrayList<Facility> = arrayListOf()
    val exclusions: ArrayList<ArrayList<Exclusion>> = arrayListOf()
}