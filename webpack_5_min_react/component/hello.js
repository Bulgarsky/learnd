import React from "react";
import styles from "./hello.module.css";

export default function ({name = 'user'}){
    console.log(styles);

    return <div className={styles.box}>
            <h2 className={styles.alert}>Hello, {name}</h2>
            <p>Webpack react</p>
        </div>;

};