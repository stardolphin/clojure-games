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

;; I'm trying to figure out threading macros
(macroexpand '(->> (load-workbook loc)                      ;; Get a workbook thing
                   (select-sheet "Worksheet" ,,,)           ;; Select Worksheet from it
                   row-seq  ,,,                             ;; Iterate the rows
                   (remove nil? ,,,)                        ;; Remove nil rows
                   (map cell-seq ,,,)                       ;; Creat a cell sequence
                   (map #(map read-cell %) ,,,)))

;;
;; (map
; (fn* [p1__2723#] (map read-cell p1__2723#))
; (map cell-seq (remove nil?
; (row-seq (select-sheet "Worksheet" (load-workbook loc))))))