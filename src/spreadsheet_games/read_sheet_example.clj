(ns spreadsheet_games.read-sheet-example)
(use 'dk.ative.docjure.spreadsheet)

(def sample "resources/sparse-sample.xlsx")

(defn read-sheet [loc]
  (->> (load-workbook loc)
       (select-sheet "Worksheet" ,,,)
       row-seq
       (remove nil?)
       (map cell-seq)
       (map #(map read-cell %))))

(read-sheet sample)

(macroexpand '(->> (load-workbook loc)
                   (select-sheet "Worksheet" ,,,)
                   row-seq
                   (remove nil?)
                   (map cell-seq)
                   (map #(map read-cell %))))

;;
;; (map
; (fn* [p1__2723#] (map read-cell p1__2723#))
; (map cell-seq (remove nil?
; (row-seq (select-sheet "Worksheet" (load-workbook loc))))))