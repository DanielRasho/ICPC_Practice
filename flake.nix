{
  description = "The lord of the Code's Vim configuration for ICPC Challenge";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    nixVim = {
      url = "github:nix-community/nixvim";
      inputs.nixpkgs.follows = "nixpkgs";
    };
  };

  outputs = {
    self,
    nixpkgs,
    nixVim,
  }: let
    forAllSystems = {
      pkgs ? nixpkgs,
      function,
    }:
      nixpkgs.lib.genAttrs [
        "x86_64-linux"
        "x86_64-macos"
        "aarch64-linux"
        "aarch64-darwin"
      ] (system:
        function {
          inherit system;
          pkgs = import pkgs {
            inherit system;
            config.allowUnfree = true;
            # overlays = [];
          };
        });
    buildVimModule = {
      system,
      module,
    }: let
      nixvimPkgs = nixVim.legacyPackages.${system};
      nixVimModule = {
        inherit module;
      };
    in
      nixvimPkgs.makeNixvimWithModule nixVimModule;
  in rec {
    devShells = forAllSystems {
      function = {
        pkgs,
        system,
      }: {
        default = pkgs.mkShell {
          packages = [
            pkgs.jdk
            pkgs.python3
            (packages.${system}.default)
          ];

          shellHook = ''
            runJava() {
            javac "$1.java"
            java "$1" < "$2"
            }

            alias vim=${packages.${system}.default}/bin/nvim

            echo "runJava {ClassName} {testFile}"
          '';
        };
      };
    };

    packages = forAllSystems {
      function = {
        pkgs,
        system,
      }: {
        default = buildVimModule {
          inherit system;
          module = ./full.nix;
        };

        minimal = buildVimModule {
          inherit system;
          module = ./minimal.nix;
        };
      };
    };
  };
}
