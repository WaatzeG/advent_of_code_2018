(ns aoc.1
  (:require [clojure.java.io :as io]))

(with-open [rdr (clojure.java.io/reader (io/resource "1_frequency_shifts.txt"))]
  (println "Frequency:" (reduce + (map #(Integer/parseInt %) (line-seq rdr)))))

(defn duplicate_frequency_filter
  ([freq_seq] (duplicate_frequency_filter freq_seq 0 #{}))
  ([frequencies current_frequency previous_frequencies]
   (let [new_frequency (+ (first frequencies) current_frequency)]
     (if
       (contains? previous_frequencies new_frequency)
       new_frequency
       (recur (rest frequencies) new_frequency (conj previous_frequencies new_frequency))))
    )
  )

(with-open [rdr (clojure.java.io/reader (io/resource "1_frequency_shifts.txt"))]
  (println "First repeated frequency:" (duplicate_frequency_filter (cycle (map #(Integer/parseInt %) (line-seq rdr)))))
  )
