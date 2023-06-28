package com.project.radiusagentassignment.models

data class FacilitiesAPIModel constructor(val id: String) {
     val facilities: List<Facility> = ArrayList()
     val exclusions: List<List<Exclusion>> = ArrayList()
}