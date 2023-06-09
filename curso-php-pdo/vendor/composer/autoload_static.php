<?php

// autoload_static.php @generated by Composer

namespace Composer\Autoload;

class ComposerStaticInit09e2df2f2cec0671b1c29f1aa0b8a2b7
{
    public static $prefixLengthsPsr4 = array (
        'A' => 
        array (
            'Alura\\Pdo\\' => 10,
        ),
    );

    public static $prefixDirsPsr4 = array (
        'Alura\\Pdo\\' => 
        array (
            0 => __DIR__ . '/../..' . '/src',
        ),
    );

    public static $classMap = array (
        'Composer\\InstalledVersions' => __DIR__ . '/..' . '/composer/InstalledVersions.php',
    );

    public static function getInitializer(ClassLoader $loader)
    {
        return \Closure::bind(function () use ($loader) {
            $loader->prefixLengthsPsr4 = ComposerStaticInit09e2df2f2cec0671b1c29f1aa0b8a2b7::$prefixLengthsPsr4;
            $loader->prefixDirsPsr4 = ComposerStaticInit09e2df2f2cec0671b1c29f1aa0b8a2b7::$prefixDirsPsr4;
            $loader->classMap = ComposerStaticInit09e2df2f2cec0671b1c29f1aa0b8a2b7::$classMap;

        }, null, ClassLoader::class);
    }
}
