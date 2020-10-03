(ns clojure-cookbook.chapter_one
  (:require [clojure.test :refer :all]))

(deftest string-to-lower
  (testing "String to lower"
    (is (= "aabbccddeeff" (clojure.string/lower-case "AaBbCcDdEeFf")))))

(deftest trim-string
  (testing "String to lower"
    (is (= "Bacon sic dolor" (clojure.string/trim " \tBacon sic dolor \n")))))

(deftest str-function
  (testing "Look at str function"
    (is (= "1 blah 2" (str 1 " " "blah" " " 2)))))

(def food-items ["milk" "butter" "flour" "eggs"])
(def joined (clojure.string/join "," food-items))
(def split-ted (clojure.string/split joined #","))

(deftest join-split
  (testing "Join and then split" (is (= food-items split-ted))))

;; Check characters for all caps
(defn yelling? [^String s]
  (every? #(or (not (Character/isLetter ^Character %))
               (Character/isUpperCase ^Character %)) s))

(deftest try-yelling (testing (is true (yelling? "HI"))))

;; int converts character to number, then char takes number to character
;; finally, str takes character to string
(deftest try-char-int (testing (is (= "a" (str (char (int \a)))))))
;; re-find finds a substring
(deftest try-re-find (testing (is "boo" (re-find #"boo" "Hey hey boo boo!"))))

;;
;; int converts character to number, then char takes number to character
;; finally, str takes character to string
(deftest try-char-int (testing (is (= "a" (str (char (int \a)))))))

;;
;; re-match works against the whole string
(deftest try-re-matches (testing
                          (is false? (re-matches #"foo" "food"))
                          (is (= "foo" (re-matches #"foo" "foo")))))

;; re-seq creates a sequence of matches
;; this is how people are defining test inputs, etc.
(deftest try-re-seq (testing "trying advanced technique"
                      (let [
                            ;; given
                            a-string "My Favorite Things"

                            ;; when
                            result (re-seq #"\w+" a-string)]

                        ;; then
                        (is (= result '("My" "Favorite" "Things"))))))

(deftest try-string-replace (testing "trying string replace"
                              (let [
                                    ;; given
                                    a-string "Cats are fun"

                                    ;; when
                                    result (clojure.string/replace a-string "Cats" "Dogs")

                                    ;; then
                                    is-same? (= result "Dogs are fun")]
                                (is is-same?))))

(deftest try-string-split (testing "trying string split without limit"
                            (let [
                                  ;; given
                                  a-string "Dogs,Are,Fun"
                                  ;; when
                                  result (clojure.string/split #"," a-string)
                                  ]
                              (is (= result '("Dogs" "Are" "Fun"))))))

;(use 'inflections.core)
;(def the-monkey (inflections.core/pluralize 1 "monkey"))

(deftest try-symbol-names (testing "Giving some name symbol conversions"
                            (is (= "valid" (str (symbol "valid"))))
                            (is (= "triumph" (name "triumph")))
                            (is (= :triumph (keyword "triumph")))
                            ))

(deftest try-big-number-mult (testing "trying multiply with large nums"
                               (let [big-num (*' 9999 9999 9999 9999 9999 9999)]
                                 (is (> big-num 999999)))))
