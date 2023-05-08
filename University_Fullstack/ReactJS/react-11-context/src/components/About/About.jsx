import React from 'react';
import {motion} from 'framer-motion';
import "../../css/for_motion.css"
const About = () => {
    console.log('Компонент "О нас"');

    return (
        <div>
            <motion.div id='company-desc'
                initial={{
                    x: -500,
                    opacity: 0
                }}
                animate={{
                    x: 300,
                    opacity: 1,
                }}
                transition={{
                    delay: 2,
                    duration: 3,
                    type: 'tween'
                }}
            >
                <br/>
                Комплекты постельного белья и полотенца  премиум качества.<br/>
                Доставка по РФ.
            </motion.div>

            <motion.div
                id='cotton-flo-div'
                initial={{
                    opacity: 0
                }}
                animate={{
                    y: 0,
                    opacity: 1,
                }}
                transition={{
                    delay: 2,
                    duration: 3,
                    type: 'tween'
                }}
            >
                <motion.img
                    src='/img/cotton-flo.png'
                    alt='cotton flower'
                    className='cotton-flo'
                    width={250}
                    initial={{
                        opacity: 0.6
                    }}

                    transition={{
                        duration: 5
                    }}

                    whileTap={{
                        rotate: 360
                    }}
                />
                <br/>
                <motion.div id='company-text'
                            initial={{
                                x: 2500,
                                opacity: 0
                            }}
                            animate={{
                                x: 100,
                                opacity: 1,
                            }}
                            transition={{
                                delay: 3,
                                duration: 2,
                                type: 'tween'
                            }}
                >
                    <h2>THE COTTON EXPERTS</h2>
                    <p>
                        The Barnhardt Family has produced cotton fiber for more than 100 years for use in medical, pharmaceutical, health, personal and home care applications. It’s earned us the title, “The First Family of American Cotton.” We are the world leader in purifying cotton using our Proprietary Ultra-Purification Process in which each individual cotton fiber is singled out, scoured, washed, cleansed, purified using gentle hydrogen peroxide, flood rinsed,
                        four-stage dried, and finished.
                        </p>
                </motion.div>
            </motion.div>

            {/*<motion.div*/}
            {/*    id='cotton-feature'*/}
            {/*    initial={{*/}
            {/*        opacity: 0,*/}
            {/*        scale: 0.5*/}
            {/*    }}*/}
            {/*    animate={{*/}
            {/*        scale: 1,*/}
            {/*        opacity: 1,*/}
            {/*    }}*/}
            {/*    transition={{*/}
            {/*        duration: 3,*/}
            {/*    }}*/}
            {/*>*/}
            {/*    <motion.img*/}
            {/*        src='/img/cotton-circle.png'*/}
            {/*        alt='cotton circle'*/}
            {/*        className='cotton-one-flo'*/}
            {/*        width={150}*/}
            {/*        initial={{*/}
            {/*            opacity: 0.6*/}
            {/*        }}*/}

            {/*        transition={{*/}
            {/*            duration: 5*/}
            {/*        }}*/}

            {/*        whileHover={{*/}
            {/*            scale:1.5,*/}
            {/*            transition: {*/}
            {/*                duration: 2*/}
            {/*            }*/}
            {/*        }}*/}
            {/*    />*/}

            {/*    <motion.div id='cotton-features-text'*/}
            {/*                initial={{*/}
            {/*                    x: -500,*/}
            {/*                    opacity: 0*/}
            {/*                }}*/}
            {/*                animate={{*/}
            {/*                    x: 100,*/}
            {/*                    opacity: 1,*/}
            {/*                }}*/}
            {/*                transition={{*/}
            {/*                    delay: 3,*/}
            {/*                    duration: 2,*/}
            {/*                    type: 'tween'*/}
            {/*                }}*/}
            {/*    >*/}
            {/*        <h3>An Extensive Technical Guide</h3>*/}
            {/*        <p>*/}
            {/*            Cotton fiber possesses a variety of distinct properties, and we know there are plenty of people who want to dig a little deeper.*/}

            {/*            That’s why we’ve packed as much technical information onto this page as humanly possible. If you have a technical mind, then this is probably the page you’ve been searching for, and dreaming about.*/}
            {/*        </p>*/}
            {/*    </motion.div>*/}
            {/*</motion.div>*/}

            <motion.div
                id='cotton-promo'
                initial={{
                    opacity: 0,
                    scale: 0.5
                }}
                animate={{
                    scale: 1,
                    opacity: 1,
                }}
                transition={{
                    duration: 3,
                }}
            >

                <motion.div id='cotton-promo-text'>
                    <motion.button className='btn btn-danger'
                                   id='btn-promo'
                                   whileHover={{
                                       scale:1.5
                                   }}
                    >
                        Акция!
                    </motion.button>

                    <p>As parents grow increasingly concerned over baby health and hygiene, and birth rates continue to rise in emerging economies, the baby care market is growing—and growing fast. In 2019, it was valued at $5.7 billion globally.</p>
                </motion.div>

                <motion.img
                    drag='x'
                    src='/img/cotton-circle.png'
                    alt='cotton circle'
                    className='cotton-one-flo'
                    width={150}
                    initial={{
                        x: 100,
                        opacity: 0.6
                    }}

                    transition={{
                        duration: 2
                    }}

                    whileDrag={{
                        scale:1.5,
                        transition: {
                            duration: 2
                        }
                    }}
                />

            </motion.div>


        </div>
    );
};

export default About;