declare module 'k-unit-converter' {
    export default UnitConverter

    declare interface Distance {
        /**
         * Convert from meters
         * @param value value in meters to convert
         * @param unit unit to convert to
         */
        fromMeters(value: number, unit: categories.Distance.DistanceUnits): number
    }

    export declare class UnitConverter {
        constructor()

        /**
         * Distance conversion
         */
        distance: Distance
    }

    /**
     * All the available units
     */
    export declare namespace categories{
        export namespace Distance{
            /**
             * Units for conversion of distances
             */
            export declare enum DistanceUnits {
                Miles,
                Km,
            }
        }
    }
}