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

